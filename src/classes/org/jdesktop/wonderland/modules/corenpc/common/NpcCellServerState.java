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
package org.jdesktop.wonderland.modules.corenpc.common;

import javax.xml.bind.annotation.XmlRootElement;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.common.cell.state.annotation.ServerState;
//import org.jdesktop.wonderland.modules.avatarbase.client.imi.ImiAvatarLoaderFactory;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigInfo;

/**
 * Represents the server-side configuration information for the NPC cell.
 * Has JAXB annotations so that it can be serialized to XML.
 * <p>
 * Keeps the relative URL of the NPC avatar configuration file.
 *
 * @author Jordan Slott <jslott@dev.java.net>
 */
@XmlRootElement(name = "npc-cell")
@ServerState
public class NpcCellServerState extends CellServerState {

    /** Default constructor */
    public NpcCellServerState() {
        if(this.getComponentServerState(this.getClass()) == null)
            {
            NpcAvatarConfigComponentServerState accss = new NpcAvatarConfigComponentServerState();
            String url = "wla://avatarbaseart/assets/configurations/MaleMeso_01.xml";
            String className = "org.jdesktop.wonderland.modules.avatarbase.client.imi.ImiAvatarLoaderFactory";
            AvatarConfigInfo info = new AvatarConfigInfo(url, className);
            accss.setAvatarConfigInfo(info);
            this.addComponentServerState(accss);
            }
    }

    @Override
    public String getServerClassName() {
        return "org.jdesktop.wonderland.modules.corenpc.server.cell.NpcCellMO";
    }
}
