package in.chandrahas.xposed.colorstatusbarlollipop;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by CHANDRAHASK on 5/20/2015.
 */
public class ColorStatusbarIconHook implements IXposedHookLoadPackage
{
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui"))//check if the package being loaded is systemUI
            return;
        try {
        findAndHookMethod("com.android.systemui.statusbar.BaseStatusBar", lpparam.classLoader, "applyColorsAndBackgrounds", "android.service.notification.StatusBarNotification", "com.android.systemui.statusbar.NotificationData.Entry", XC_MethodReplacement.DO_NOTHING );
        } catch (Throwable t) { XposedBridge.log(t); }
    }
}
