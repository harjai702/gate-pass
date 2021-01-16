package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import javax.validation.constraints.NotEmpty;

@Controller
public class homecontroll {
    private String userName="harshharjai@gmail.com";
    private String password="";
    private String subject="";
    private String message="";
    private String port="587";
    private String host="smtp.gmail.com";
    private String emale;
    private String fname;
    private String ret;
    private String usrmail="";
    @Autowired
    datarepo repo;
    @Autowired
    userrepo usrepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    ///////////////////////////////////////////////////
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
       String username=getuser();
        ModelAndView mv=new ModelAndView("1st");
        mv.addObject("uss",username);
        return mv;
    }
    @RequestMapping("/temp")
    public String temp(){
        return "temp";
    }
    @RequestMapping("/getres")
    public String getres(@ModelAttribute Tempp t){
        System.out.println(t.getName());
        return t.getName();
    }
    ////////////////////////////////////////////////////
    @RequestMapping("/login")
    public String logi(){
        return "login";
    }
    ////////////////////////////////////////////////////
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public @ResponseBody data1 log(@RequestBody data1 da, HttpServletRequest request) throws MessagingException {
        String username=getuser();
        ModelAndView mv=new ModelAndView("success");
        mv.addObject("uss",username);
        List<data1> lst=(List<data1>)repo.findAll();
        int sz=lst.size();
        sz++;
        da.setIdd(sz);
        repo.save(da);
        Optional<users> u=usrepo.findById(username);
        u.ifPresent(user -> {
            emale=user.getEmail();
            fname=user.getFlname();
        });
        subject = "Chitkara University"+"\n"+"Gate Paas Requested";
        message="Hey "+fname+"("+username+") "+".Your gate paas Request has been Registered Successfully.";
        sendEmail(emale);
        return da;
    }
    /////////////////////////////////////////////////////
    @RequestMapping("gendata")
    @ResponseBody
    public ModelAndView gendata() {
        String username=getuser();
        List<data1> lst=(List<data1>)repo.findAll();
        //Iterator<data> itr = lst.iterator();
        ModelAndView mv=new ModelAndView("log");
        mv.addObject("lists",lst);
        mv.addObject("uss",username);
        //while(itr.hasNext()) { //data da=itr.next(); mv.addObject("one",itr.next());
        //}

        //System.out.println(repo.findByQw("de"));
        //System.out.println(repo.findByUserrGreaterThan(102));
        //data da=repo.findById(userr).orElse(new data());
        //return repo.findAll().toString();
        //mv.addObject("one",da);
        return mv;
    }
    ///////////////////////////////////////////
    @RequestMapping("acpt")
    public String acpt(@RequestParam int idd,@RequestParam String status) throws MessagingException {
        data1 da=repo.findById(idd).orElse(new data1());
        da.setStatus(status);
        repo.save(da);
        String username=da.getNme();
        Optional<users> u=usrepo.findById(username);
        u.ifPresent(user -> {
            emale=user.getEmail();
            fname=user.getFlname();
        });
        if(da.getStatus().equals("Approved")){
            subject = "Chitkara University"+"\n"+"Gate Paas Approved";
            message="Hey "+fname+"("+username+") "+". Your gate paas has been Approved";
            sendEmail(emale);
        }
        else{
            subject = "Chitkara University"+"\n"+"Gate Paas Rejected";
            message="Hey "+fname+"("+username+") "+". Your gate paas has been Rejected";
            sendEmail(emale);
        }

        return "redirect:/gendata";
    }
    //////////////////////////////////////////////////
    public void sendEmail(String toAddress) throws AddressException,MessagingException{
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        Transport.send(msg);
    }
    ///////////////////////////////////////////////
    @RequestMapping("signup")
    public String siup(){
        return "signup";
    }
    @RequestMapping("signsubmit")
    public String signu(users ur){
    String a=ur.getPassword();
    String encodePWD=passwordEncoder.encode(a);
    ur.setPassword(encodePWD);
        usrepo.save(ur);
        return "/";
    }
    ///////////////////////////////////////////////////
    @RequestMapping("resetpass")
    public String reset(){
        return "reset";
    }
    ///////////////////////////////////////////////////////
    @RequestMapping(value="/enterotp1", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String  enterotp1(@RequestParam("aa") String username,HttpServletRequest request) {
        Optional<users> u=usrepo.findById(username);
        if(u.isPresent()){
            return "true";
        }
        return "false";
    }
    @RequestMapping("entrotp")
    public ModelAndView entotp(@RequestParam@NotEmpty String username) throws MessagingException {
      Optional<users> u=usrepo.findById(username);
        u.ifPresent(user -> {
           usrmail=user.getEmail();
        });
        int max=1000000;
        int min=100000;
       int r = ThreadLocalRandom.current().nextInt(min, max + 1);
        subject="OTP to Reset Your Password!";
        message="Your Opt to Reset your password is :"+r;
        sendEmail(usrmail);
        String r1=Integer.toString(r);
        ModelAndView mv=new ModelAndView("enterotp");
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(
                r1.getBytes(StandardCharsets.UTF_8) );
        mv.addObject("r1",encodedString);
        mv.addObject("mail",username);
        return mv;
    }
    ///////////////////////////////////////////////
    @RequestMapping(value="/verifyotp", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String  submittedFromData(@RequestParam("aa") String otp,@RequestParam("bb") String r1,HttpServletRequest request) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(r1);
        String r2=new String(decodedByteArray);
        if(otp.equals(r2)){
            return "true";
        }
        else{
            return "false";
        }
    }
    @RequestMapping("newpass")
    public ModelAndView newpass(@RequestParam String username){
        ModelAndView mv=new ModelAndView("newpass");
        mv.addObject("usr",username);
        return mv;
    }
    //////////////////////////////////////
    @RequestMapping("finalreset")
    public void finalreset(@RequestParam@NotEmpty String username,@RequestParam@NotEmpty String nwpass){
        Optional<users> u=usrepo.findById(username);
        String encodepwd=passwordEncoder.encode(nwpass);
        u.ifPresent(user -> {
            user.setPassword(encodepwd);
            usrepo.save(user);
        });

        System.out.print("Password Changed Successfully!");
    }
    /////////////////////////
    public String getuser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usrnam;
        if (principal instanceof UserDetails) {
            usrnam = ((UserDetails)principal).getUsername();
        } else {
            usrnam = "Please Login!";
        }
        return usrnam;
    }
    @RequestMapping("exp")
    public void exp() {
        String name = "Harsh Harjai";
        usrepo.findByFlname(name);
    }

}
