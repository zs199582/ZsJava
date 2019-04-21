package cn.javaSE;

import org.junit.jupiter.api.Test;

import java.io.*;

public class SEIO {
    /**
     * 拷贝文件
     * @param src
     * @param dest
     * @throws Exception
     */
    public static void copyFile(String src,String dest) throws Exception
    {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);

        int count;

        byte[] buffer = new byte[10*1024];//10kb缓冲

        while((count = in.read(buffer,0,buffer.length))!=-1)
        {
            out.write(buffer,0,count);
        }
        in.close();
        out.close();
    }
    @Test
    public void rowOutputFile() throws Exception
    {
        FileReader fileReader = new FileReader("新建文本文档(2)");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line=bufferedReader.readLine())!=null)
        {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    /**
     * 列出磁盘下所有文件
     * @param dir
     */
    public void listAllFiles(File dir)
    {
        if(dir == null||dir.exists())
            return;
        if(dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for(File file:dir.listFiles())
            listAllFiles(file);
    }
    public void outputFileContent(String filename) throws FileNotFoundException,IOException
    {
        FileReader fileReader = new FileReader(new File(filename));
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        while((line = br.readLine())!=null)
            System.out.println(line);
        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        br.close();
    }
}
