/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.fediz.core.config;

import org.apache.cxf.fediz.core.config.jaxb.ProtocolType;
import org.apache.cxf.fediz.core.config.jaxb.SamlProtocolType;
import org.apache.cxf.fediz.core.saml.SAMLTokenValidator;
import org.apache.cxf.fediz.core.samlsso.AuthnRequestBuilder;
import org.apache.cxf.fediz.core.samlsso.DefaultAuthnRequestBuilder;
import org.apache.wss4j.common.util.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SAMLProtocol extends Protocol {

    private static final Logger LOG = LoggerFactory.getLogger(SAMLProtocol.class);
    
    private AuthnRequestBuilder authnRequestBuilder;
    
    public SAMLProtocol(ProtocolType protocolType) {
        super(protocolType);
        
        // add SAMLTokenValidator as the last one
        // Fediz chooses the first validator in the list if its
        // canHandleToken or canHandleTokenType method return true
        SAMLTokenValidator validator = new SAMLTokenValidator();
        getTokenValidators().add(getTokenValidators().size(), validator);
    }
    
    protected SamlProtocolType getSAMLProtocol() {
        return (SamlProtocolType)super.getProtocolType();
    }

    protected void setSAMLProtocol(SamlProtocolType samlProtocol) {
        super.setProtocolType(samlProtocol);
    }

    public boolean isSignRequest() {
        return getSAMLProtocol().isSignRequest();
    }

    public void setSignRequest(boolean signRequest) {
        getSAMLProtocol().setSignRequest(signRequest);
    }
    
    public AuthnRequestBuilder getAuthnRequestBuilder() {
        if (authnRequestBuilder != null) {
            return authnRequestBuilder;
        }
        
        // See if we have a custom AuthnRequestBuilder
        String authnRequestBuilderStr = getSAMLProtocol().getAuthnRequestBuilder();
        if (authnRequestBuilderStr != null && !"".equals(authnRequestBuilderStr)) {
            try {
                Class<?> authnRequestBuilderClass = Loader.loadClass(authnRequestBuilderStr);
                authnRequestBuilder = (AuthnRequestBuilder) authnRequestBuilderClass.newInstance();
            } catch (ClassNotFoundException ex) {
                LOG.debug(ex.getMessage(), ex);
            } catch (InstantiationException ex) {
                LOG.debug(ex.getMessage(), ex);
            } catch (IllegalAccessException ex) {
                LOG.debug(ex.getMessage(), ex);
            }
        }
        
        // Default implementation
        authnRequestBuilder = new DefaultAuthnRequestBuilder();
        
        return authnRequestBuilder;
    }

    public void setAuthnRequestBuilder(AuthnRequestBuilder authnRequestBuilder) {
        this.authnRequestBuilder = authnRequestBuilder;
    }
    
    
}
