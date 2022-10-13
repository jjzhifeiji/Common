package com.zhifeiji.common.mpchart.interfaces.dataprovider;

import com.zhifeiji.common.mpchart.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
