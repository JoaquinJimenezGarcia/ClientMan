package controller;

import model.Correo;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by garci on 22/05/2017.
 */

/**
 * Clase encargada de la transmisión de correos electrónicos
 * Usa el cliente de gmail y un correo para mandarlos como si fuese este.
 */
public class EnvioCorreo {
    /**
     *
     * @param c = correo que recibe y que intententará enviar
     * @return true si lo manda o false si ha habido algún error
     */
    public boolean enviarCorreo(Correo c){
        /**
         * Intenta establecer todos los propiedades del correo.
         */
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable","true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", c.getUsuarioCorreo()); // De aquí obtiene el usuario con el que lo mandará
            p.setProperty("mail.smtp.auth","true");

            Session s = Session.getDefaultInstance(p,null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(c.getMsg());

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
            mensaje.setSubject(c.getAsunto());
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            // Hay que especificar un usuario y una contraseña que te proporciona Gmail
            // al darlo de alta como aplicación de terceros.
            t.connect(c.getUsuarioCorreo(),c.getPasswd());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;
        }catch (Exception e){
            System.out.println("Ha habido un error.");
            return false;
        }
    }
}
