import java.io.*;

public class Task10 {
    public void split(String source, String destinationPrefix, long maxSize) throws IOException
    {
        try(BufferedInputStream fileInputStream =  new BufferedInputStream( new FileInputStream(source)))
        {
            int value; //количество байт прочитанных из файла
            long currentSize = maxSize;
            int fileNum = 0;
            while(currentSize > Integer.MAX_VALUE)
            {
                currentSize -= Integer.MAX_VALUE;
                byte[] buf = new byte[1024];
                while((value = fileInputStream.read(buf) )!=-1)
                {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPrefix+"."+fileNum+".txt",true));
                    bufferedOutputStream.write(buf,0,value);
                }
                if(currentSize <= Integer.MAX_VALUE)
                {
                    byte[] buf2 = new byte[(int)currentSize];
                    while((value = fileInputStream.read(buf) )!=-1)
                    {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPrefix+"."+fileNum+".txt", true));
                        bufferedOutputStream.write(buf2,0,value);
                        bufferedOutputStream.close();
                        fileNum++;

                    }
                }
            }
            if(maxSize > Integer.MAX_VALUE) return;

            byte[] buf = new byte[(int)currentSize];
            while((value = fileInputStream.read(buf) )!=-1)
            {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPrefix+"."+fileNum+".txt",true));
                bufferedOutputStream.write(buf,0,value);
                bufferedOutputStream.close();
                fileNum++;

            }
        }

    }
}

