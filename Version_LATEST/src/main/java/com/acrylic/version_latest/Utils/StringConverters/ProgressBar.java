package com.acrylic.version_latest.Utils.StringConverters;

import com.acrylic.version_latest.Messages.ChatUtils;
import lombok.Getter;
import lombok.Setter;

public class ProgressBar {

    private final StringBuilder progressBarBuilder;
    private final int totalSize;
    private final int each;

    @Setter @Getter
    private String colorFilled = "&a&l";
    @Setter @Getter
    private String colorEmpty = "&c&l";

    /**
     *
     * @param progressBar The bar design you want to use.
     *                    For example, if you want to have a progress bar like:
     *                      ||||||||||||||||||||
     *                    Then specify:
     *                      ||||||||||||||||||||
     */
    public ProgressBar(String progressBar) {
        this.progressBarBuilder = new StringBuilder(progressBar);
        totalSize = progressBar.length();
        each = 1;
    }

    /**
     *
     * @param bar The icon used to display EACH INDIVIDUAL bar.
     * @param amount The amount of bar of the full progress bar,
     *
     * Example, ProgressBar("|",20) -> ||||||||||||||||||||
     *          ProgressBar("Hi",20) -> HiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHiHi
     *                                  (Yes, you can do this)
     */
    public ProgressBar(String bar,int amount) {
        StringBuilder progressBarBuilder = new StringBuilder(bar);
        for (int i = 1;i<amount;i++) progressBarBuilder.append(bar);
        this.progressBarBuilder = progressBarBuilder;
        totalSize = progressBarBuilder.length();
        each = bar.length();
    }

    /**
     *
     * @param percentage in terms of % (i.e. 10.1%, 20%, 74.25553%)
     * @return
     */
    public String construct(float percentage) {
        percentage = (percentage > 100) ? 1 : (percentage < 0) ? 0 : percentage / 100;
        int index = (int) Math.floor(percentage * ((float) totalSize / each));
        progressBarBuilder.insert(index * each,colorEmpty);
        return ChatUtils.get(colorFilled + progressBarBuilder.toString());
    }


}
