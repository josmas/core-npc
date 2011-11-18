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

// XXX Figure out incompatible license? XXX

/* This code was developed with funding from the project "España Virtual"
 * 
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *  
 * "España Virtual es un proyecto de I+D, subvencionado por el CDTI dentro del
 * programa Ingenio 2010, orientado a la definición de la arquitectura,
 * protocolos y estándares del futuro Internet 3D, con un foco especial en lo
 * relativo a visualización 3D, inmersión en mundos virtuales, interacción
 * entre usuarios y a la introducción de aspectos semánticos, sin dejar de lado
 * el estudio y maduración de las tecnologías para el procesamiento masivo y
 * almacenamiento de datos geográficos.
 *
 * Con una duración de cuatro años, el proyecto está liderado por DEIMOS Space
 * y cuenta con la participación del Centro Nacional de Información Geográfica
 * (IGN/CNIG), Grid Systems, Indra Espacio, GeoVirtual, Androme Ibérica,
 * GeoSpatiumLab, DNX y una decena de prestigiosos centros de investigación y
 * universidades nacionales."
 */

package org.jdesktop.wonderland.modules.corenpc.common;

import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.common.cell.CellTransform;
import org.jdesktop.wonderland.common.cell.messages.CellMessage;


/**
 * A message to indicate a change in position of the NPC Cell.
 *
 * @author david <dmaroto@it.uc3m.es>
 * @author Jordan Slott <jslott@dev.java.net>
 */
public class NpcCellChangeMessage extends CellMessage {
    
    private CellTransform transform;

    public NpcCellChangeMessage(CellID cellID, CellTransform transform) {
        super(cellID);
        this.transform = transform;
    }

    public CellTransform getCellTransform(){
        return transform;
    }
}
