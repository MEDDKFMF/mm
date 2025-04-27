/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.csule1.web;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import java.util.logging.Logger;

/**
 *
 * @author chinmayi
 * My code is based on Instructor's Example
 */
public class JSFPhaseListener  implements PhaseListener{

     private static final Logger LOG = Logger.getLogger(JSFPhaseListener.class.getName());

    /**
     *
     * @return
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
    /**
     *
     * @param event
     */
    @Override
    public void beforePhase(PhaseEvent event) {
          if(event.getPhaseId() == PhaseId.RESTORE_VIEW){
            LOG.info(" ***** Beginning New JSF Request  *****************" );
        }        
        
        LOG.info("************* Before********* Phase **" + event.getPhaseId().toString());
    }

    /**
     *
     * @param event
     */
    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.info(" **************   After " + event.getPhaseId().toString());
        
        if(event.getPhaseId() == PhaseId.RENDER_RESPONSE){
            LOG.info("****** ENDING JSF Request  **********" );
        } 
    }

    
  
    
}
