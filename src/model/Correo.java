package model;

/**
 * Created by garci on 22/05/2017.
 */
public class Correo {
    /**
     * Atributos que contendrá el correo
     */
    private String usuarioCorreo; // Cuenta de email desde la que se va a mandar
    private String passwd; // Contraseña proporcionada, en este caso por Google
    private String destino; // Correo del destinatario
    private String asunto; // Asunto del correo
    private String msg; // Cuerpo del mensaje

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
