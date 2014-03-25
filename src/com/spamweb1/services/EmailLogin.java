package com.spamweb1.services;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spamfilter.maildownload.RetriveUserCreditional;
import com.spamfilter.utility.IPAddressFromMsgID;

@Path("/auth")
public class EmailLogin {


	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean validateCredentials(EmailUser user){
		return user.validateUser();
	}

	@GET
	@Path("/emails")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmailInfo> getEmails(){
		return new EmailUser().getEmails();
	}

	@GET
	@Path("/spamemails")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmailInfo> getSpamEmail(){
		return new EmailUser().getSpamEmails();
	}

	@GET
	@Path("/refresh")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean refreshEmails(){
		new RetriveUserCreditional().fetchEmail();
		
		return true;
	}

	@GET
	@Path("/ip/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLatLog(@PathParam("param") String messageId) {
		messageId = messageId.replaceAll("MYHASH", "#");
		String ipAddress = "";
		IPAddressFromMsgID ip=new IPAddressFromMsgID();
		ipAddress = ip.getIpGeniun(messageId);
		GeoLocClient geoc = new GeoLocClient();
		return geoc.getLocatonDetails(ipAddress);
	}
	
	@GET
	@Path("/ipspam/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getLatLogSpamEmail(@PathParam("param") String messageId) {
		messageId = messageId.replaceAll("MYHASH", "#");
		String ipAddress = "";
		IPAddressFromMsgID ip=new IPAddressFromMsgID();
		ipAddress = ip.getIpSpam(messageId);
		GeoLocClient geoc = new GeoLocClient();
		return geoc.getLocatonDetails(ipAddress);
	}
}
