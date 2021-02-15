import java.io.*;

public class Task10 {
    public void split(String source, String destinationPrefix, long maxSize) throws IOException
    {
        try(BufferedInputStream fileInputStream =  new BufferedInputStream( new FileInputStream(source)))
        {
            int value;

            long currentSize = maxSize;
            int fileNum = 0;
            while(currentSize > Integer.MAX_VALUE)
            {
                currentSize -= Integer.MAX_VALUE;

            }

            byte[] buf = new byte[(int)currentSize];
            while((value = fileInputStream.read(buf) )!=-1)
            {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationPrefix+"."+fileNum+".txt"));
                byte[] buf2 =
                bufferedWriter.write(,0,currentSize);
            }
        }

    }
}

