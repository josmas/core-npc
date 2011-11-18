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

import com.jme.bounding.BoundingBox;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.wonderland.common.annotation.Plugin;
import org.jdesktop.wonderland.common.cell.CellTransform;
import org.jdesktop.wonderland.common.cell.MultipleParentException;
import org.jdesktop.wonderland.common.cell.state.PositionComponentServerState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigComponentServerState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigInfo;
import org.jdesktop.wonderland.modules.corenpc.common.NpcCellServerState;
import org.jdesktop.wonderland.server.ServerPlugin;
import org.jdesktop.wonderland.server.cell.CellManagerMO;

// XXX NOT SUPPORTED XXX

/**
 *
 * @author paulby
 */
//@Plugin
//public class NpcPluginSrv implements ServerPlugin {

//    private String[] npcs = new String[] {
////        "assets/configurations/ObamaTest.xml",
////        "assets/configurations/MaleD_CA_00_bin.xml",
////        "assets/configurations/MaleD_CA_01_bin.xml",
////        "assets/configurations/FemaleD_AZ_00_bin.xml",
////        "assets/configurations/FemaleD_CA_00_bin.xml",
////        "assets/configurations/FemaleFG_AA_01_bin.xml",
////        "assets/configurations/FemaleFG_AA_02_bin.xml",
////        "assets/configurations/FemaleFG_AA_03_bin.xml",
////        "assets/configurations/FemaleFG_AA_04_bin.xml",
////        "assets/configurations/FemaleFG_AA_05_bin.xml",
////        "assets/configurations/FemaleFG_AA_06_bin.xml",
////        "assets/configurations/FemaleFG_CA_00_bin.xml",
////        "assets/configurations/FemaleFG_CA_01_bin.xml",
////        "assets/configurations/FemaleFG_CA_02_bin.xml",
////        "assets/configurations/FemaleFG_CA_03_bin.xml",
////        "assets/configurations/FemaleFG_CA_04_bin.xml",
////        "assets/configurations/FemaleFG_CA_05_bin.xml",
////        "assets/configurations/FemaleFG_CA_06_bin.xml",
////        "assets/configurations/FemaleFG_CA_07_bin.xml",
////        "assets/configurations/MaleD_CA_00_bin.xml",
////        "assets/configurations/MaleD_CA_01_bin.xml",
////        "assets/configurations/MaleFG_AA_00_bin.xml",
////        "assets/configurations/MaleFG_AA_01_bin.xml",
////        "assets/configurations/MaleFG_AA_02_bin.xml",
////        "assets/configurations/MaleFG_AA_03_bin.xml",
////        "assets/configurations/MaleFG_AA_04_bin.xml",
////        "assets/configurations/MaleFG_CA_01_bin.xml",
////        "assets/configurations/MaleFG_CA_03_bin.xml",
////        "assets/configurations/MaleFG_CA_04_bin.xml",
////        "assets/configurations/MaleFG_CA_05_bin.xml",
////        "assets/configurations/MaleFG_CA_06_bin.xml",
////        "assets/configurations/MaleMeso_00.xml",
//        "assets/configurations/MaleMeso_01.xml"
//    };
//
//    public void initialize() {
//        createDemoAvatars();
//    }
//
//    private void createDemoAvatars() {
//        Logger.getLogger(NpcPluginSrv.class.getName()).warning("# of avatars " + npcs.length);
//
//        for (int i = 0; i < npcs.length; i++) {
//            // Create the server state that describes the NPC.
//            NpcCellServerState state = new NpcCellServerState();
//
//            PositionComponentServerState pcss = new PositionComponentServerState();
//            CellTransform transform = calcTransform(i);
//            pcss.setTranslation(transform.getTranslation(null));
//            pcss.setRotation(transform.getRotation(null));
//            pcss.setScaling(transform.getScaling(null));
//            pcss.setBounds(new BoundingBox(new Vector3f(0, 1, 0), 1, 2, 1));
//            state.addComponentServerState(pcss);
//
//            AvatarConfigComponentServerState accss = new AvatarConfigComponentServerState();
//            String url = "wla://avatarbaseart@localhost:8080/" + npcs[i];
//            String className = "org.jdesktop.wonderland.modules.avatarbase.client.imi.ImiAvatarLoaderFactory";
//            AvatarConfigInfo avatarConfigInfo = new AvatarConfigInfo(url, className);
//            accss.setAvatarConfigInfo(avatarConfigInfo);
//            state.addComponentServerState(accss);
//
//            state.setRelativeConfigURL(npcs[i]);
//            NpcCellMO cellMO = new NpcCellMO();
//            cellMO.setServerState(state);
//
//            try {
//                CellManagerMO.getCellManager().insertCellInWorld(cellMO);
//            } catch (MultipleParentException ex) {
//                Logger.getLogger(NpcPluginSrv.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Logger.getLogger(NpcPluginSrv.class.getName()).warning("Inserting NPC into world " + npcs[i]);
//        }
//    }
//
//    private CellTransform calcTransform(int index) {
//        if (false) {
//            // Lineup
//            Quaternion lookDir = new Quaternion();
//            lookDir.lookAt(new Vector3f(-1,0,0), new Vector3f(0,1,0));
//            return new CellTransform(lookDir, new Vector3f(2,0,2+index));
//        } else {
//            // Circle
//            double delta = (2*Math.PI/npcs.length);
//            double angle = delta*index;
//            double gap = 1.6;  // Distance between avatars;
//            double radius = gap/Math.sin(delta);
//
//            if (angle>Math.PI)
//                angle = -(angle-Math.PI);
//
//            Vector3f pos = new Vector3f((float)(Math.sin(angle)*radius), 0f, (float)(Math.cos(angle)*radius));
//            Quaternion lookDir = new Quaternion();
//            lookDir.lookAt(new Vector3f(-pos.x,0,-pos.z), new Vector3f(0,1,0));
//            return new CellTransform(lookDir, pos);
//        }
//    }
//}
