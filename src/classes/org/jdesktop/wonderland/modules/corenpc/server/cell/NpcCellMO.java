/**
 * Open Wonderland
 *
 * Copyright (c) 2010, Open Wonderland Foundation, All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * The Open Wonderland Foundation designates this particular file as
 * subject to the "Classpath" exception as provided by the Open Wonderland
 * Foundation in the License file that accompanied this code.
 */

/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied
 * this code.
 */
package org.jdesktop.wonderland.modules.corenpc.server.cell;

import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.common.cell.ClientCapabilities;
import org.jdesktop.wonderland.common.cell.messages.CellMessage;
import org.jdesktop.wonderland.common.cell.state.CellClientState;
import org.jdesktop.wonderland.modules.corenpc.common.NpcCellChangeMessage;
import org.jdesktop.wonderland.modules.corenpc.common.NpcCellClientState;
import org.jdesktop.wonderland.modules.corenpc.common.NpcCellServerState;
import org.jdesktop.wonderland.server.cell.AbstractComponentMessageReceiver;
import org.jdesktop.wonderland.server.cell.CellMO;
import org.jdesktop.wonderland.server.cell.ChannelComponentMO;
import org.jdesktop.wonderland.server.cell.MovableComponentMO;
import org.jdesktop.wonderland.server.comms.WonderlandClientID;
import org.jdesktop.wonderland.server.comms.WonderlandClientSender;

/**
 * The server-side Cell MO for the NPC Cell.
 * 
 * @author paulby
 * @author david <dmaroto@it.uc3m.es> UC3M - "Project España Virtual"
 * @author Jordan Slott (jslott@dev.java.net)
 */
public class NpcCellMO extends CellMO {
    // The relative avatar configuration URL
    private String relativeConfigURL = null;

    /** Default constructor */
    public NpcCellMO() {
        
    }

    /**
     * Returns the URL of the avatar configuration, relative to the module.
     * 
     * @return The relative URL of the avatar configuration file
     */
    public String getRelativeConfigURL() {
        return relativeConfigURL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getClientCellClassName(WonderlandClientID clientID,
                                            ClientCapabilities capabilities) {
        return "org.jdesktop.wonderland.modules.corenpc.client.cell.NpcCell";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CellServerState getServerState(CellServerState state) {
        // Create an appropriate NPC server state if one does not exist
        if (state == null) {
            state = new NpcCellServerState();
        }
        return super.getServerState(state);
    }

    @Override
    public void setServerState(CellServerState state) {
        super.setServerState(state);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public CellClientState getClientState(CellClientState state,
            WonderlandClientID clientID, ClientCapabilities capabilities) {

        // Create a new client state if one does not exist
        if (state == null) {
            state = new NpcCellClientState();
        }
        return super.getClientState(state, clientID, capabilities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setLive(boolean live) {
        super.setLive(live);

        ChannelComponentMO channel = getComponent(ChannelComponentMO.class);
        if (live) {
            MovableComponentMO mc = getComponent(MovableComponentMO.class);
            if (mc != null) {
                removeComponent(mc);
            }
            addComponent(new MovableNpcComponentMO(this));
        
            channel.addMessageReceiver(NpcCellChangeMessage.class, new NpcCellMessageReceiver(this));
        } else {
            channel.removeMessageReceiver(NpcCellChangeMessage.class);
        }
    }

    /**
     * A class to receive NpcCellChangeMessages and relay them to all clients.
     */
    private static class NpcCellMessageReceiver extends AbstractComponentMessageReceiver {
        public NpcCellMessageReceiver(NpcCellMO cellMO) {
            super(cellMO);
        }

        /**
         * {@inheritDoc}
         */
        public void messageReceived(WonderlandClientSender sender,
                WonderlandClientID clientID, CellMessage message) {

            NpcCellMO cellMO = (NpcCellMO)getCell();
            NpcCellChangeMessage sccm = (NpcCellChangeMessage)message;
            cellMO.setLocalTransform(sccm.getCellTransform());
            cellMO.sendCellMessage(clientID, message);
        }
    }
}
