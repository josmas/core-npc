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
package org.jdesktop.wonderland.modules.corenpc.client.cell;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Properties;
import org.jdesktop.wonderland.client.cell.registry.annotation.CellFactory;
import org.jdesktop.wonderland.client.cell.registry.spi.CellFactorySPI;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.avatarbase.client.imi.ImiAvatarLoaderFactory;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigInfo;
import org.jdesktop.wonderland.modules.corenpc.common.NpcAvatarConfigComponentServerState;
import org.jdesktop.wonderland.modules.corenpc.common.NpcCellServerState;

/**
 * The cell factory for the sample cell.
 * 
 * @author Jordan Slott <jslott@dev.java.net>
 */
@CellFactory
public class NpcCellFactory implements CellFactorySPI {

    public String[] getExtensions() {
        return new String[] {};
    }

    public <T extends CellServerState> T getDefaultCellServerState(Properties props) {
        NpcCellServerState state = new NpcCellServerState();

        // Attach an avatar config component to the server state. This will help
        // configure the appearance of the NPC.
        NpcAvatarConfigComponentServerState accss = new NpcAvatarConfigComponentServerState();
        String url = "wla://avatarbaseart/assets/configurations/MaleMeso_01.xml";
        String className = ImiAvatarLoaderFactory.class.getName();
        AvatarConfigInfo info = new AvatarConfigInfo(url, className);
        accss.setAvatarConfigInfo(info);
        state.addComponentServerState(accss);

        return (T)state;
    }

    public String getDisplayName() {
        return "NPC";
    }

    public Image getPreviewImage() {
        URL url = NpcCellFactory.class.getResource("resources/NPC2.png");
        return Toolkit.getDefaultToolkit().createImage(url);
    }
}
