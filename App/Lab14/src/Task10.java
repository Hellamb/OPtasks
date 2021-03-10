import java.io.*;

public class Task10 {
    int BUFFER_MAX_SIZE = 8192; // зависит от компьютера, больше лучше не ставить
    public void split(String source, String destinationPrefix, long maxSize) throws IOException
    {
        try(BufferedInputStream fileInputStream =  new BufferedInputStream( new FileInputStream(source)))
        {
            int bufferSize;   //размер буфера
            if(maxSize>BUFFER_MAX_SIZE)   //
            {
                bufferSize = BUFFER_MAX_SIZE;
            }else if(maxSize<=0)
            {
                throw new IllegalArgumentException("maxSize ");
            }else
            {
                bufferSize = (int)maxSize;
            }
            long currentSize = 0; //текущее количество прочитанных байтов, до смены файла
            int lastPoint = bufferSize; //количество байт, которые нужно считать, до предела буфера либо файла
            int value;  //количество байт прочитанных из файла
            int fileNum = 0; //номер файла
            boolean isLast = false; //флаг для проверки, нужно ли менять номер файла
            byte[] buf = new byte[lastPoint];
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPrefix+"."+fileNum+".txt",true));
            while((value = fileInputStream.read(buf,0, lastPoint))!=-1)
            {
                bufferedOutputStream.write(buf,0,value);
                currentSize+= value;

                if(isLast) //меняет номер файла и сбрасывает значения до изначальных
                {
                    fileNum++;
                    bufferedOutputStream.close();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPrefix+"."+fileNum+".txt",true));
                    lastPoint = bufferSize;
                    isLast = false;
                    currentSize = 0;
                }

                if((maxSize-currentSize) < bufferSize) // если выполняется, то считает не более чем нужно за следующий заход и изменит номер файла(на следующем заходе)
                {
                    lastPoint = (int)(maxSize-currentSize);
                    isLast = true;

                }
            }
            bufferedOutputStream.close();
        }

    }
}
