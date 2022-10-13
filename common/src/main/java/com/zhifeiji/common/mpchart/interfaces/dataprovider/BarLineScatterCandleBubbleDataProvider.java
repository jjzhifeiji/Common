package com.zhifeiji.common.mpchart.interfaces.dataprovider;

import com.zhifeiji.common.mpchart.components.YAxis.AxisDependency;
import com.zhifeiji.common.mpchart.data.BarLineScatterCandleBubbleData;
import com.zhifeiji.common.mpchart.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
