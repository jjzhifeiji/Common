package com.zhifeiji.common.mpchart.interfaces.dataprovider;

import com.zhifeiji.common.mpchart.components.YAxis;
import com.zhifeiji.common.mpchart.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
