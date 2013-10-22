/* Copyright (c) 2011 Danish Maritime Authority
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dma.enav.shore.msi.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;

import dk.dma.enav.shore.msi.domain.Message;
import dk.dma.enav.shore.msi.service.MessageService;

@Path("/message")
public class MessageRestService {
    
    @Inject
    private Logger log;
    
    @EJB
    private MessageService messageService;

    public MessageRestService() {        
    }
    
    @GET
    @Path("/test")
    public String test() {
        log.info("Hello from test");
        return "Hello world";        
    }
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Message> getAll() {
        return messageService.getAll();
    }
    
    

}
