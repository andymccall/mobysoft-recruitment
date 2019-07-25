package com.mobysoft.configuration;

import org.junit.Assert;
import org.junit.Test;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.Assert.*;

public class SwaggerConfigurationTest {

    @Test
    public void SwaggerConfiguration_verifyDocket_Passes() throws Exception {
        Docket docket = new SwaggerConfiguration().api();
        Assert.assertNotNull(docket);
        Assert.assertEquals("recruitment.mobysoft.com", docket.getGroupName());
    }

}