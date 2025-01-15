package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import org.example.services.AuthService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Api("Job Role Application API")
@Path("/api/job-role-application")
@SwaggerDefinition(
    securityDefinition = @SecurityDefinition(
        apiKeyAuthDefinitions = {
            @ApiKeyAuthDefinition(
                    key = HttpHeaders.AUTHORIZATION,
                    name = HttpHeaders.AUTHORIZATION,
                    in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER
            )
        }
    )
)

public class JobRoleApplicationController {
//    static final Logger LOGGER =
//            LoggerFactory.getLogger(JobRoleApplicationController.class);
//
//    final JobRoleApplicationService
//            jobRoleApplicationService;
//
//    public JobRoleApplicationController
//    (final JobRoleApplicationService service) {
//        this.jobRoleApplicationService = service;
//        LOGGER.info("Initialised");
//    }

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            final @FormDataParam("file")InputStream fileInputStream,
            final @FormDataParam("file")FormDataContentDisposition
                    fileMetaData) throws Exception {
        String uploadPath = "/Users/aaron.millen/Documents"
                + "/EAYL Academy/Final Project/kainos-job-api/uploads";
        final int byteLimit = 1024;
        try {
            int read = 0;
            byte[] bytes = new byte[byteLimit];

            OutputStream out = new FileOutputStream(
                    new File(uploadPath + fileMetaData.getFileName()));
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new WebApplicationException(
                    "Error while uploading file. Please try again !!");
        }
        return Response.ok("Data uploaded successfully !!").build();
    }

}
