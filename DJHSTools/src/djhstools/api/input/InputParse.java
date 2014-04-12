package djhstools.api.input;

import java.io.InputStream;

public class InputParse extends AbstractParse{
    InputStream inputStream;
    public InputParse(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public InputStream newInputStream() {
        return inputStream;
    }
}
