package teamDA.catcafe.stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutput extends ObjectOutputStream {
    // ObjectOutputStream(직렬화스트림))-> 받아올 객체가 필요해
    public MyObjectOutput(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader();
    }
}
