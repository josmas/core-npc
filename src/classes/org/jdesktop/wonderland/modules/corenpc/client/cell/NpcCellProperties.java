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

import java.net.URL;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.cell.asset.AssetUtils;
import org.jdesktop.wonderland.client.cell.properties.CellPropertiesEditor;
import org.jdesktop.wonderland.client.cell.properties.annotation.PropertiesFactory;
import org.jdesktop.wonderland.client.cell.properties.spi.PropertiesFactorySPI;
import org.jdesktop.wonderland.client.comms.WonderlandSession;
import org.jdesktop.wonderland.client.login.LoginManager;
import org.jdesktop.wonderland.modules.avatarbase.client.cell.AvatarConfigComponent;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigComponentServerState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigInfo;
import org.jdesktop.wonderland.modules.corenpc.common.NpcCellServerState;

// XXX NOT TESTED XXX

/**
 * A property sheet for the NPC Cell.
 *
 * @author Jordan Slott <jslott@dev.java.net>
 */
@PropertiesFactory(NpcCellServerState.class)
public class NpcCellProperties extends JPanel implements PropertiesFactorySPI {
    private static final Logger LOGGER =
            Logger.getLogger(NpcCellProperties.class.getName());

    private final int totalAvatars = 100;
    private String[] theAvatar = new String[totalAvatars];
    private int thisAvatar = 0;

    // The cell property editor panel, used to indicate clean/dirty state
    CellPropertiesEditor editor = null;

    // The original value of the selected configuration relative URL
    private String originalConfigURL = null;

    /** Creates new form SampleCellProperties */
    public NpcCellProperties()
        {
        initComponents();
    }

    /**
     * @inheritDoc()
     */
    public String getDisplayName() {
        return "NPC";
    }

    /**
     * @inheritDoc()
     */
    public JPanel getPropertiesJPanel() {
        return this;
    }

    /**
     * @inheritDoc()
     */
    public void setCellPropertiesEditor(CellPropertiesEditor editor) {
        this.editor = editor;
    }

    /**
     * @inheritDoc()
     */
    public void open() {
        // Fetch the current state from the cell's server state and update
        // the GUI.
        Cell cell = editor.getCell();
        AvatarConfigComponent acc = cell.getComponent(AvatarConfigComponent.class);
        originalConfigURL = acc.getAvatarConfigInfo().getAvatarConfigURL();
        System.out.println("OriginalConfigURL = " + originalConfigURL);
        
        avatarCB.setSelectedItem(originalConfigURL);

//        if(jRadioIMI.isSelected())
//            {
//            jRadioIMIActionPerformed(null);
//            }
//        else if(jRadioEvolver.isSelected())
//            {
//            jRadioEvolverActionPerformed(null);
//            }
    }

    /**
     * @inheritDoc()
     */
    public void close() {
        // Do nothing for now.
    }

    /**
     * @inheritDoc()
     */
    public void apply() {
        // Take the value from the configuration URL and populate the server
        // state with it.
        String uri = null;

        WonderlandSession session = LoginManager.getPrimary().getPrimarySession();
        String userName = session.getUserID().getUsername();

        if(jRadioIMI.isSelected())
            {
            uri = "wla://avatarbaseart/assets/configurations/" + (String) avatarCB.getSelectedItem();
            }
        else if(jRadioEvolver.isSelected())
            {
            uri = "wlcontent://users/" + userName + "/avatars/multimesh-evolver/" + (String) avatarCB.getSelectedItem();
            }
        AvatarConfigComponentServerState accss = (AvatarConfigComponentServerState)
                 editor.getCellServerState().getComponentServerState(AvatarConfigComponentServerState.class);
        AvatarConfigInfo info = accss.getAvatarConfigInfo();
        if(jRadioIMI.isSelected())
            {
            accss.setAvatarConfigInfo(new AvatarConfigInfo(uri, "org.jdesktop.wonderland.modules.avatarbase.client.imi.ImiAvatarLoaderFactory"));
            }
        else if(jRadioEvolver.isSelected())
            {
            accss.setAvatarConfigInfo(new AvatarConfigInfo(uri, "org.jdesktop.wonderland.modules.evolvermulti.client.evolver.MultimeshEvolverAvatarLoaderFactory"));
            }
        LOGGER.warning("Setting config info to " + accss.getAvatarConfigInfo().getAvatarConfigURL());
        editor.addToUpdateList(accss);
    }

    /**
     * @inheritDoc()
     */
    public void restore() {
        avatarCB.setSelectedItem(originalConfigURL);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        avatarCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jRadioIMI = new javax.swing.JRadioButton();
        jRadioEvolver = new javax.swing.JRadioButton();

        jLabel1.setText("Choose Avatar:");

        avatarCB.setEditable(true);
        avatarCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatarCBActionPerformed(evt);
            }
        });

        jLabel2.setText("Avatar Type");

        buttonGroup1.add(jRadioIMI);
        jRadioIMI.setText("IMI Avatars");
        jRadioIMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioIMIActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioEvolver);
        jRadioEvolver.setSelected(true);
        jRadioEvolver.setText("Evolver Avatars");
        jRadioEvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioEvolverActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(51, 51, 51)
                        .add(jRadioIMI)
                        .add(29, 29, 29)
                        .add(jRadioEvolver))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1)
                        .add(40, 40, 40)
                        .add(avatarCB, 0, 310, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jRadioIMI)
                    .add(jRadioEvolver))
                .add(53, 53, 53)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(avatarCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void avatarCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatarCBActionPerformed
                // If the shape type has changed since the initial value, then
        // set the dirty bit to try
        String configURL = (String)avatarCB.getSelectedItem();
        if (configURL != null && !configURL.equals(originalConfigURL)) {
            editor.setPanelDirty(NpcCellProperties.class, true);
        } else {
            editor.setPanelDirty(NpcCellProperties.class, false);
        }
    }//GEN-LAST:event_avatarCBActionPerformed

    private void jRadioIMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioIMIActionPerformed
        avatarCB.removeAllItems();
        thisAvatar = 0;
        try
            {
            URL urell = AssetUtils.getAssetURL("wla://avatarbaseart/assets/configurations/content.txt");

            java.net.URLConnection con = urell.openConnection();
            con.connect();

            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
            String line;
            for(; (line = in.readLine()) != null; )
                {
                theAvatar[thisAvatar] = line;
                thisAvatar++;
                if(thisAvatar >= totalAvatars)
                    {
                    break;
                    }
                }
            }
        catch (Exception ex)
            {
            ex.printStackTrace();
            }
      for(int i = 0; i < thisAvatar; i++)
            {
            avatarCB.addItem(theAvatar[i]);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioIMIActionPerformed

    private void jRadioEvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioEvolverActionPerformed
        avatarCB.removeAllItems();
        thisAvatar = 0;
        try
            {
            WonderlandSession session = LoginManager.getPrimary().getPrimarySession();
            String userName = session.getUserID().getUsername();
            String thePath = session.getSessionManager().getServerURL();
            URL urell = new URL(thePath + "/webdav/content/users/" + userName + "/avatars/multimesh-evolver/content.txt");

            java.net.URLConnection con = urell.openConnection();
            con.connect();

            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
            String line;
            for(; (line = in.readLine()) != null; )
                {
                theAvatar[thisAvatar] = line;
                thisAvatar++;
                if(thisAvatar >= totalAvatars)
                    {
                    break;
                    }
                }
            }
        catch (Exception ex)
            {
            ex.printStackTrace();
            }

        for(int i = 0; i < thisAvatar; i++)
            {
            avatarCB.addItem(theAvatar[i]);
            }
    }//GEN-LAST:event_jRadioEvolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox avatarCB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioEvolver;
    private javax.swing.JRadioButton jRadioIMI;
    // End of variables declaration//GEN-END:variables
}
