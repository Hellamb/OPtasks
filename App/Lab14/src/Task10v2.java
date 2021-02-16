import java.io.*;

public class Task10v2 {
    public void split(String source, String destinationPrefix, long maxSize) throws IOException
    {
        try(BufferedInputStream fileInputStream =  new BufferedInputStream( new FileInputStream(source)))
        {
            long currentSize = 0; //текущее количество прочитанных байтов, до смены файла
            int bufferSize;   //размер буфера
            if(maxSize>512)   //
            {
                bufferSize = 2048;
            }else
            {
                bufferSize = (int)maxSize;
            }
            int lastPoint = bufferSize; //количество байт, которые нужно считать, до предела буфера либо файла
            int value;  //количество байт прочитанных из файла
            int fileNum = 0; //номер файла
            boolean isLast = false; //флаг для проверки, нужно ли менять номер файла
            byte[] buf = new byte[lastPoint];
            while((value = fileInputStream.read(buf,0, lastPoint))!=-1)
            {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPrefix+"."+fileNum+".txt",true));
                bufferedOutputStream.write(buf,0,value);
                currentSize+= value;

                if(isLast) //меняет номер файла и сбрасывает значения до изначальных
                {
                    fileNum++;
                    lastPoint = bufferSize;
                    isLast = false;
                    currentSize = 0;
                }

                if((maxSize-currentSize) < bufferSize) // если выполняется, то считает не более чем нужно за следующий заход и изменит номер файла(на следующем заходе)
                {
                    lastPoint = (int)(maxSize-currentSize);
                    isLast = true;

                }
                bufferedOutputStream.close();

            }
        }

    }
}
