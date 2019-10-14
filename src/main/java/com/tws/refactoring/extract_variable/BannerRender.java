package com.tws.refactoring.extract_variable;

public class BannerRender {

    public static final String MAC = "MAC";
    public static final String IE = "IE";

    public String renderBanner(String platform, String browser) {

        if (checkIEonMac(platform, browser)) {
            return "IE on Mac?";
        }
        return "banner";
    }

    private boolean checkIEonMac(String platform, String browser) {

        return (platform.toUpperCase().contains(MAC)) && (browser.toUpperCase().contains(IE));

    }
}
