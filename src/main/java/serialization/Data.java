package serialization;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 498597869869L;
    private String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{data=[" + data + "]}";
    }

    //replacing serialized object to DataProxy object
    @Serial
    private Object writeReplace() {
        return new DataProxy (this);
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws InvalidObjectException {
        throw new InvalidObjectException ("Proxy is not used, something fishy");
    }

    private static class DataProxy implements Serializable {
        @Serial
        private static final long serialVersionUID = 9469680899L;
        private static final String PREFIX = "NONONO";
        private static final String SUFFIX = "ENDEND";
        private String dataProxy;

        private DataProxy(Data d) {
            this.dataProxy = PREFIX + d.data + SUFFIX;
        }

        @Serial
        private Object readResolve() throws InvalidObjectException {
            if (dataProxy.startsWith (PREFIX) && dataProxy.endsWith (SUFFIX)) {
                return new Data (dataProxy.substring (6, dataProxy.length () - 6));
            } else throw new InvalidObjectException ("data corrupted");
        }
    }
}
