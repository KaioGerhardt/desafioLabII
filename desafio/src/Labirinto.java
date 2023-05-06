import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

// testes
import java.nio.file.Paths;

public class Labirinto {

    private char[][] labirinto;
    private BufferedReader BufferFile;
    private FileReader FileReader;

    public static void main(String[] args) throws Exception {

        // testes das funcoes
        String filename = "/home/kaio/Documentos/desafioLabII/desafio/src/teste.txt";
        try {
            Labirinto classLabirinto = new Labirinto();
            classLabirinto.criaLabirinto(filename);
            classLabirinto.percorreLabirinto();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void criaLabirinto(String filename) throws IOException {

        try {
            FileReader = new FileReader(filename);
            BufferFile = new BufferedReader(FileReader);

            int linha = this.countFile(filename, 2);
            int coluna = this.countFile(filename, 1);
            String lineLab = null;

            labirinto = new char[linha][coluna];

            for (int i = 0; i < labirinto.length; i++) {
                lineLab = BufferFile.readLine();
                for (int j = 0; j < labirinto[i].length; j++)
                    labirinto[i][j] = lineLab.charAt(j);
            }

            BufferFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int countFile(String filename, int option) {
        int cont = 0;
        switch (option) {
            case 1:
            //colum
                try {
                    FileReader FileReaderCount = new FileReader(filename);
                    BufferedReader BufferFileCount = new BufferedReader(FileReaderCount);

                    String lineColumn = null;
                    lineColumn = BufferFileCount.readLine();
                    cont = lineColumn.length();
                
                    FileReaderCount.close();
                    BufferFileCount.close();
                    
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
            //line
                try {
                    FileReader FileReaderCountLine = new FileReader(filename);
                    BufferedReader BufferFileCountLine = new BufferedReader(FileReaderCountLine);

                    String line = null;
                    do {
                        line = BufferFileCountLine.readLine();
                        cont++;
                    } while (line != null);
                    cont -= 1;
                    

                    FileReaderCountLine.close();
                    BufferFileCountLine.close();
                    
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return cont;
    }

    public boolean percorreLabirinto(){
        return walkMazeRecursive(0, 0);
    }


    private boolean walkMazeRecursive(int linha, int coluna) {
        if (linha < 0 || linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length) {
            return false;
        }
        
        if (labirinto[linha][coluna] == 'D') {
            return true;
        }
        
        if (labirinto[linha][coluna] == 'X' || labirinto[linha][coluna] == '*') {
            return false;
        }
        
        labirinto[linha][coluna] = '*';
        
        boolean isExit = walkMazeRecursive(linha - 1, coluna) ||
                           walkMazeRecursive(linha, coluna + 1) ||
                           walkMazeRecursive(linha + 1, coluna) ||
                           walkMazeRecursive(linha, coluna - 1);
        
        if (!isExit) {
            labirinto[linha][coluna] = ' ';
        }
        
        return isExit;
    }
}
