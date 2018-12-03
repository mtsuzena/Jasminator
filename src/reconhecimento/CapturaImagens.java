// https://github.com/bytedeco/javacv/wiki
// haarcascade_frontalface_alt Algoritmo ja treinado para detecção de faces

package reconhecimento;

import Controller.Menu_loginController;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.AudioClip;
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

public class CapturaImagens {
    private boolean chave;
    private static boolean inicio_fotos;
    private static boolean estagio_fotos;

    
    public static void capturaImg() throws FrameGrabber.Exception, InterruptedException{
        new Thread(){
            public void run(){    
                // Monitora os eventos do teclado   Importação java.awt.event.KeyEvent
                KeyEvent tecla = null;
                inicio_fotos=true;
                estagio_fotos=true;

                // Converter imagem do disco ou web para formato mat (matriz)   
                //OBS: o JAVACV ja converte para matriz com esse metodo... se fosse com OPENCV teria que criar na mao
                OpenCVFrameConverter.ToMat converteMat = new OpenCVFrameConverter.ToMat();

                // Objeto para fazer captura da web cam  BS: parametro 0 é referente ao numero da camera, 
                // nosso caso é a web cam... se tivesse duas camera no pc teria a 0 e 1 
                OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);


                try {
                    // inicia a captura das imagens pela web cam
                    camera.start();
                } catch (FrameGrabber.Exception ex) {
                    Logger.getLogger(CapturaImagens.class.getName()).log(Level.SEVERE, null, ex);
                }

                CascadeClassifier detectorFace = new CascadeClassifier("src\\recursos\\classificadores\\haarcascade-frontalface-alt.xml");

                // Algoritmo 1 de reconhecimento
                EigenFaceRecognizer reconhecedor = EigenFaceRecognizer.create();
                reconhecedor.read("src\\recursos\\classificadores\\classificadorEigenFaces.yml");

                // Algoritmo 2 de reconhecimento
                //FisherFaceRecognizer reconhecedor = FisherFaceRecognizer.create();
                //reconhecedor.read("src\\recursos\\classificadores\\classificadorFisherFaces.yml");

                // Algoritmo 3 de reconhecimento
                //LBPHFaceRecognizer reconhecedor = LBPHFaceRecognizer.create();
                //reconhecedor.read("src\\recursos\\classificadorLBPH.yml");


                // Janela de visualização da camera // Ja vem pronto no JAVACV tbm // 
                // 1 param = Titulo da janela, 2 param CFG grafica por default ambos sao 2.2 --> COM BASE NA DOCUMENTACAO 
                // DO JAVA É recomendado utilziar para fins de otmização de processamento de hardware
                // Obs: o cFrame esta sendo executando la em baixo.. junto com o metodo showImage
                CanvasFrame cFrame = new CanvasFrame("Reconhecimento Facial", CanvasFrame.getDefaultGamma() / camera.getGamma());

                // Objeto do tipo Frame para armazenar os frames da webcam
                Frame frameCapturado = null;

                // Jogar o frameCapturado na imagemColorida // Por meio da imagem colorida faremos a detecção das faces
                Mat imagemColorida = new Mat();

                // Variavel limite de amostras, no nosso caso as fotos
                int numeroAmostras = 51;
                // Variavel para contar ate o maximo de amostrar
                int amostra = 1;

                // variavel para armazenar o ID da pessoa
                int idPessoa = 1;
                
                int fotosTirada=0;
                
                int cont=0;
                int tirando_foto=0;
                int sequencia_foto=1;
                
                // Joga o que esta sendo capturado pela webcam no frameCapturado e 
                // enquanto estiver capturando com a webcam ele executa o while
                while(idPessoa<=2){
                    try {
                        while ((frameCapturado = camera.grab()) != null){
                            // convertemos o frameCapturado para uma matriz e
                            // jogamos na imagemColorida   // Tbm ja pronto no javacv
                            
                            imagemColorida = converteMat.convert(frameCapturado);
                            System.out.println(cont);
                            cont++;
                            
                            System.out.println(imagemColorida);
                            
                            // novo objeto mat --> um tipo de matriz
                            Mat imagemCinza = new Mat();
                            
                            // metodo para transormar a imagem colorida em cinza
                            // 1 param = imagem que sera convertida // 2 param = onde sera armazenado a imagem convertida
                            //3 param = Como quer fazer a conversão... no Caso COLOR_BGRA2GRAY para converter em cinza
                            cvtColor(imagemColorida, imagemCinza, COLOR_BGRA2GRAY);
                            
                            // Objetvo do tipo RectVector para Armazenar todas as faces que conseguir detectar na imagem
                            RectVector facesDetectadas = new RectVector();
                            
                            // metodo --> proxima VERSAO sera explicado melhor UHDAUSHDUASHDUHASUDHASUH
                            // param 1 = imagem em escala de cinza // 2 param = joga para a facesDetectadas todas as imagem que detectar
                            // 3 param = tamanho da escala da imagem     // 4 param = numero de vizinhos   // 5 parama usado versao antiga entao coloca 0
                            // 6 parama = dimensao minima para detectar a face na webcam    // 7 param = tamanho maximo para detectar a face
                            detectorFace.detectMultiScale(imagemCinza, facesDetectadas, 1.1, 1, 0, new Size(150,150), new Size(500,500));
                            if (tecla == null){
                                try {
                                    tecla = cFrame.waitKey(5);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(CapturaImagens.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            for (int i=0; i < facesDetectadas.size(); i++){
                                Rect dadosFace = facesDetectadas.get(0);
                                rectangle(imagemColorida, dadosFace, new Scalar(0,0,255, 0));
                                Mat faceCapturada = new Mat(imagemCinza, dadosFace);
                                resize(faceCapturada, faceCapturada, new Size(160,160));
                                
                                IntPointer rotulo = new IntPointer(1);
                                DoublePointer confianca = new DoublePointer(1);
                                reconhecedor.predict(faceCapturada, rotulo, confianca);
                                String nome;
                                
                                /*if (confianca.get(0) > 7000){
                                    nome = "Desconhecido";
                                }else{
                                    //nome = pessoas[predicao] + " - " + confianca.get(0);
                                    nome = "Foto" +fotosTirada+ " - " + confianca.get(0);
                                }*/
                                
                                nome = "Foto " +fotosTirada+" de 100 "+" - " + confianca.get(0);
                                
                                if((fotosTirada>0 && fotosTirada<2)){ 
                                    Menu_loginController.setEstagio_reproducao_audio(1);
                                }
                                
                                // Se a teclado for diferente de null, ou seja, teclado pressionado
                                //if (tecla != null){
                                    // "q" foi utilizado para capturar as fotos
                                    //if (tecla.getKeyChar() == 'q' || tecla.getKeyChar() == 'Q'){
                                    System.out.println("ESAGIO DO CAP = "+Menu_loginController.getEstagio_reproducao_audio());
                                    if(cont>170){    
                                        if(tirando_foto==0){
                                            if (amostra <= numeroAmostras){
                                                System.out.println(inicio_fotos);
                                                if(inicio_fotos==true){   
                                                    //Salva imagem em disco como JPG
                                                    imwrite("src\\fotos\\pessoa."+idPessoa+"."+amostra+".jpg",faceCapturada);
                                                    // Imprimi quantas fotos que foi tirada para maior controla
                                                    System.out.println("Foto "+idPessoa+"."+amostra+" capturada\n");
                                                    String musicFile = getClass().getResource("/sons/tirando_foto.mp3").toString();
                                                    AudioClip clip = new AudioClip(musicFile);
                                                    
                                                    clip.play();
                                                    amostra++;
                                                    fotosTirada++;
                                                    sequencia_foto++;
                                                    
                                                }
                                            }
                                        }
                                        tirando_foto++;
                                    }
                                    
                                    if(tirando_foto>1){
                                        tirando_foto=0;
                                    }
                                    
                                    
                                    
                                    if(fotosTirada==20&&estagio_fotos==true){
                                        Menu_loginController.setEstagio_reproducao_audio(2);
                                        inicio_fotos=false;
                                        estagio_fotos=false;
                                    }
                                    if(fotosTirada==24)
                                        estagio_fotos=true;
                                    
                                    if(fotosTirada==40&&estagio_fotos==true){
                                        Menu_loginController.setEstagio_reproducao_audio(3);
                                        inicio_fotos=false;
                                        estagio_fotos=false;
                                    }
                                    if(fotosTirada==44)
                                        estagio_fotos=true;
                                    
                                    if(fotosTirada==60&&estagio_fotos==true){
                                        Menu_loginController.setEstagio_reproducao_audio(4);
                                        inicio_fotos=false;
                                        estagio_fotos=false;
                                    }
                                    if(fotosTirada==64)
                                        estagio_fotos=true;
                                    
                                    if(fotosTirada==80&&estagio_fotos==true){
                                        Menu_loginController.setEstagio_reproducao_audio(5);
                                        inicio_fotos=false;
                                        estagio_fotos=false;
                                    }
                                    
                                    if(fotosTirada==84)
                                        estagio_fotos=true;
                                    
                                    if(fotosTirada==100&&estagio_fotos==true){
                                        Menu_loginController.setEstagio_reproducao_audio(6);
                                        inicio_fotos=false;
                                        estagio_fotos=false;
                                    }
                                    //}
                                    //tecla = null;
                                //}

                                int x = Math.max(dadosFace.tl().x() - 10, 0);
                                int y = Math.max(dadosFace.tl().y() - 10, 0);
                                putText(imagemColorida, nome, new Point(x, y), FONT_HERSHEY_PLAIN, 1.4, new Scalar(0, 255, 0, 0));
                            }
                            
                            // Deve pressionar a tecla durante o tempo setado para poder tirar a foto
                            if (tecla == null){
                                try {
                                    tecla = cFrame.waitKey(20);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(CapturaImagens.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            // Se a camera estiver visivel passa os frames capturados pela web para o objeto
                            // cFrame, em seguida chama o metodo showImage para mostrar na tela
                            if (cFrame.isVisible()){
                                cFrame.showImage(frameCapturado);
                            }
                            
                            if (amostra == numeroAmostras){
                                if(idPessoa==2){
                                    idPessoa=3;
                                    break;
                                }
                                amostra=1;
                                idPessoa=2;
                                break;
                            }
                        }
                    } catch (FrameGrabber.Exception ex) {
                        Logger.getLogger(CapturaImagens.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // Libera a memoria da jnaela cFrame
                cFrame.dispose();
                try {
                    // Desliga a webcam
                    camera.stop();
                } catch (FrameGrabber.Exception ex) {
                    Logger.getLogger(CapturaImagens.class.getName()).log(Level.SEVERE, null, ex);
                }
                Treinamento.treinador();
            }
        }.start();
    }
    
    public static void setIniciFotos(boolean set){
        inicio_fotos=set;
    }
    
   

}