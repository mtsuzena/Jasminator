package reconhecimento;

import java.awt.event.KeyEvent;
import java.util.Scanner;
import static javafx.application.Platform.exit;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.javacpp.opencv_core.FONT_HERSHEY_PLAIN;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Point;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_face.EigenFaceRecognizer;
import org.bytedeco.javacpp.opencv_face.FisherFaceRecognizer;
import org.bytedeco.javacpp.opencv_face.LBPHFaceRecognizer;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;
import static org.bytedeco.javacpp.opencv_imgproc.putText;
import static org.bytedeco.javacpp.opencv_imgproc.rectangle;
import static org.bytedeco.javacpp.opencv_imgproc.resize;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class Reconhecedor {
    
    private boolean chave;
    private int decisao;
    private String nome;
    
    
    public boolean reconhece() throws FrameGrabber.Exception, InterruptedException{
        int a=0;
        this.chave=false;
        KeyEvent tecla = null;
        OpenCVFrameConverter.ToMat converteMat = new OpenCVFrameConverter.ToMat();
        OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);
        String[] pessoas = {"", "Mateus", "Mateus"};
        camera.start();
        
        CascadeClassifier detectorFace = new CascadeClassifier("src\\recursos\\classificadores\\haarcascade-frontalface-alt.xml");
        EigenFaceRecognizer reconhecedor = EigenFaceRecognizer.create();
        reconhecedor.read("src\\recursos\\classificadores\\classificadorEigenFaces.yml");
        //FisherFaceRecognizer reconhecedor = FisherFaceRecognizer.create();
        //reconhecedor.read("src\\recursos\\classificadores\\classificadorFisherFaces.yml");
        //LBPHFaceRecognizer reconhecedor = LBPHFaceRecognizer.create();
        //reconhecedor.read("src\\recursos\\classificadores\\classificadorLBPH.yml");
        
        //CanvasFrame.getDefaultGamma() / camera.getGamma()
        
        CanvasFrame cFrame = new CanvasFrame("Reconhecedor", 1);
        Frame frameCapturado = null;
        Mat imagemColorida = new Mat();
        int numeroAmostras = 26;
        int amostra = 1;
        int cont = 0; 
       
        while ((frameCapturado = camera.grab()) != null){
        //while (cont <= 50000){  
            //System.out.println(cont);
            
            /*if(cont>=200){
                this.chave = false;
                break;
            }*/
            cont++;            
            imagemColorida = converteMat.convert(frameCapturado);
            Mat imagemCinza = new Mat();
            cvtColor(imagemColorida, imagemCinza, COLOR_BGRA2GRAY);
            RectVector facesDetectadas = new RectVector();
            detectorFace.detectMultiScale(imagemCinza, facesDetectadas, 1.1, 1, 0, new Size(150,150), new Size(500,500));
            if (tecla == null){
                tecla = cFrame.waitKey(5);
            }
            for (int i=0; i < facesDetectadas.size(); i++){
                Rect dadosFace = facesDetectadas.get(0);
                rectangle(imagemColorida, dadosFace, new Scalar(0,0,255, 0));
                Mat faceCapturada = new Mat(imagemCinza, dadosFace);
                resize(faceCapturada, faceCapturada, new Size(160,160));
                
                IntPointer rotulo = new IntPointer(1);
                DoublePointer confianca = new DoublePointer(1);
                reconhecedor.predict(faceCapturada, rotulo, confianca);
                int predicao = rotulo.get(0);
                this.decisao = (int) confianca.get(0);
                //String nome;
                System.out.println(a);
                a++;
                if(a==150){
                    camera.stop();
                    cFrame.dispose();
                    
                    return false;
                }
                /*if (decisao > 5000){
                    this.nome = "Desconhecido";
                    System.out.println("Voce nao tem permissa para"
                            + " alterar os cadastros");
                    this.chave=false;
                    //break;
                }else if (decisao <= 5000){
                    this.nome = pessoas[predicao] + " - " + confianca.get(0);
                    System.out.println("Voce tem permissao para alterar"
                            + "os cadastros");
                    this.chave=true;
                    //break;
                }*/
               
                /*if(pessoas[predicao]=="Eduarda"){
                    this.chave = true;
                    break;
                }*/
                
                if (decisao > 3000) {
                    this.nome = "Desconhecido... - "+confianca.get(0);
                    ///this.chave = false;
                } else {
                    //this.nome = pessoas[predicao] + " - " + confianca.get(0);
                    this.nome = "Reconhecendo... - "+confianca.get(0);
                    //this.chave = true;
                    //break;
                }
                
                if(confianca.get(0)<3500){
                    this.chave = true;
                    camera.stop();
                    cFrame.dispose();
                    camera.close();
                   
                    break;
                }
                
               int x = Math.max(dadosFace.tl().x() - 10, 0);
               int y = Math.max(dadosFace.tl().y() - 10, 0);
               putText(imagemColorida, this.nome, new Point(x, y), FONT_HERSHEY_PLAIN, 1.4, new Scalar(0, 255, 0, 0));
               
            }
            
            if(this.chave){
                camera.stop();
                cFrame.dispose();
                camera.stop();
                break;
            }
            
            if (cFrame.isVisible()){
                cFrame.showImage(frameCapturado);
            }
            
            
            if (tecla != null){
                    // "q" foi utilizado para capturar as fotos
                    if (tecla.getKeyChar() == 'q'){
                        break;
                    }
                    tecla = null;
            }
            
            
         
        }
        camera.stop();
        cFrame.dispose();
        camera.stop();
        camera.close();
        return this.chave;
    }
}
