/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opengg.module.swt.window;

import com.opengg.core.engine.EngineInfo;
import com.opengg.core.exceptions.WindowCreationException;
import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.io.input.mouse.MouseController;
import com.opengg.core.render.window.Window;
import com.opengg.module.swt.input.SWTKeyboardHandler;
import com.opengg.module.swt.input.SWTMouseButtonHandler;
import com.opengg.module.swt.input.SWTMousePosHandler;
import com.opengg.module.swt.window.GLData.API;
import com.opengg.module.swt.window.GLData.Profile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.GL_NO_ERROR;
import static org.lwjgl.opengl.GL11.glGetError;

/**
 *
 * @author Javier
 */
public class GGCanvas implements Window{
    
    long id;
    GLCanvas canvas;
    boolean success = false;
    
    SWTKeyboardHandler keyCallback;
    SWTMousePosHandler mousePosCallback;
    SWTMouseButtonHandler mouseCallback;
    
    public GGCanvas(Shell shell){
        GLData data = new GLData();
        data.api = API.GL;
        data.majorVersion = 3;
        data.minorVersion = 2;
        data.samples = 4;
        data.profile = Profile.CORE;
        data.swapInterval = 1;
        data.forwardCompatible = true;
        canvas = new GLCanvas(shell, SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE, data);
        canvas.setCurrent();
        id = canvas.context;
        GL.createCapabilities();
        
        shell.addKeyListener(keyCallback = new SWTKeyboardHandler());
        shell.addMouseMoveListener(mousePosCallback = new SWTMousePosHandler());
        shell.addMouseListener(mouseCallback = new SWTMouseButtonHandler());
        
        KeyboardController.setHandler(keyCallback);
        MouseController.setPosHandler(mousePosCallback);
        MouseController.setButtonHandler(mouseCallback);
        
        if(glGetError() == GL_NO_ERROR){
            success = true;
            EngineInfo.window = this;
            EngineInfo.windowType = EngineInfo.SWT;
        }
        else
            throw new WindowCreationException("OpenGL initialization during window creation failed");

    }
    
    @Override
    public void endFrame() {
        canvas.swapBuffers();
    }

    @Override
    public float getRatio() {
        return getWidth()/getHeight();
    }

    @Override
    public boolean shouldClose() {
        return canvas.isDisposed();
    }

    @Override
    public void destroy() {
        canvas.dispose();
    }

    @Override
    public long getID() {
        return id;
    }

    @Override
    public int getWidth() {
        return canvas.getSize().x;
    }

    @Override
    public int getHeight() {
        return canvas.getSize().y;
    }

    @Override
    public boolean getSuccessfulConstruction() {
        return success;
    }
    
}
