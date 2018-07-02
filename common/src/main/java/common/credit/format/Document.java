package common.credit.format;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "document")
public class Document implements Serializable {

    private Response response;
    private Signature signature;

    public Document() {
    }

    public Document(Response response, Signature signature) {
        this.response = response;
        this.signature = signature;
    }

    public Response getResponse() {
        return response;
    }

    @XmlElement
    public void setResponse(Response response) {
        this.response = response;
    }

    public Signature getSignature() {
        return signature;
    }

    @XmlElement
    public void setSignature(Signature signature) {
        this.signature = signature;
    }

}
