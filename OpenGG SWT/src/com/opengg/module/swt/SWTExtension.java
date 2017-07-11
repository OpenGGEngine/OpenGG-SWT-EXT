/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opengg.module.swt;

import com.opengg.core.extension.Extension;
import com.opengg.core.render.window.WindowTypeRegister;
import com.opengg.module.swt.window.GGCanvas;
import org.eclipse.swt.widgets.Shell;

/**
 *
 * @author Javier
 */
public class SWTExtension extends Extension{
    public Shell shell;
    
    public SWTExtension(Shell shell){
        extname = "SWT Window Support";
        requirement = LWJGL;
        this.shell = shell;
    }
    
    @Override
    public void loadExtension() {
        WindowTypeRegister.registerWindowType("SWT", new GGCanvas(shell));
    }
    
}
