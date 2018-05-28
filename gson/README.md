Gson Wrapper
------------

The original Gson JAR file is comes with all necessary OSGi headers to be deployed nicely in OSGi containers.

In AEM 6.3 however it is not possible to deploy updated Gson libraries because they are blacklisted in the `crx-quickstart/launchpad/sling_bootstrap.txt` that is part of the AEM quickstart - the problematic lines are these:

```
# CQ-73191 - Remove pre-BSN-rename bundles that might be left after upgrade
uninstall rngom
uninstall joda-time
uninstall com.google.gson
```

Please note that the problem occurs only if the Gson library is part of an AEM package - in this case the bundle is ignored silently. If you deploy the Gson bundle directly to the Felix console it works.

If you want to deploy an updated Gson library in AEM 6.3 via AEM content packages you need to change the line `uninstall com.google.gson` to something like `uninstall com.google.gson [0,2.8.3]` to exclude your version.

If you want or cannot change these lines on all your instances you can use this wrapper library: `io.wcm.osgi.wrapper:io.wcm.osgi.wrapper.gson`.
