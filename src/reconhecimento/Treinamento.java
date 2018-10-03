/*
CLASSE PARA TREINAR A INTELIGENCIA ARTIFICAL A RECONHECER AS FACES
COM BASE NAS FOTOS QUE FORAM CAPTURADAS PELA CLASSE CapturaImagens
*/


// Importacoes necessarias para o correto funcionamento da API JAVACV
package reconhecimento;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;
import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_face.EigenFaceRecognizer;
import org.bytedeco.javacpp.opencv_face.FisherFaceRecognizer;
import org.bytedeco.javacpp.opencv_face.LBPHFaceRecognizer;

import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.resize;
import org.opencv.face.FaceRecognizer;


//CLASSE TREINAMENTO (EXPLICADO ACIMA)
public class Treinamento {
    public static void treinador(){
        // Diretorio onde as fotos capturas foram armazenadas
        File diretorio = new File("src\\fotos");
        FilenameFilter filtroImagem = new FilenameFilter(){
            @Override
            public boolean accept(File dir, String nome){
                return nome.endsWith(".jpg") || nome.endsWith(".gif") || nome.endsWith(".png");
            }
        };
        
        File[] arquivos = diretorio.listFiles(filtroImagem);
        MatVector fotos = new MatVector(arquivos.length);
        Mat rotulos = new Mat(arquivos.length, 1, CV_32SC1);
        IntBuffer rotulosBuffer = rotulos.createBuffer();
        int contador = 0;
        for (File imagem: arquivos){
            Mat foto = imread(imagem.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
            int classe = Integer.parseInt(imagem.getName().split("\\.")[1]);
            //System.out.println(classe);
            resize(foto,foto, new Size(160,160));
            fotos.put(contador, foto);
            rotulosBuffer.put(contador, classe);
            contador++;
            
        } 
        
        EigenFaceRecognizer eigenfaces = EigenFaceRecognizer.create();
        FisherFaceRecognizer fisherfaces = FisherFaceRecognizer.create();
        LBPHFaceRecognizer lbph = LBPHFaceRecognizer.create(2,9,9,9,1);
        
        eigenfaces.train(fotos, rotulos);
        eigenfaces.save("src\\recursos\\classificadores\\classificadorEigenFaces.yml");
        fisherfaces.train(fotos, rotulos);
        fisherfaces.save("src\\recursos\\classificadores\\classificadorFisherFaces.yml");
        lbph.train(fotos, rotulos);
        lbph.save("src\\recursos\\classificadores\\classificadorLBPH.yml");
        System.out.println("Treinado com sucesso!!");
    }
    }