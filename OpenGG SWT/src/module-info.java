/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module com.opengg.swt {
    requires swt;
    requires org.lwjgl;
    requires org.lwjgl.opengl;
    requires com.opengg.core;
    requires com.opengg.math;
    
    exports com.opengg.module.swt;
    exports com.opengg.module.swt.input;
    exports com.opengg.module.swt.window;
}
