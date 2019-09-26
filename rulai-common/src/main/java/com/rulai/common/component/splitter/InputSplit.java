package com.rulai.common.component.splitter;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/6 13:30
 */
public class InputSplit {
    
    private String lowerBoundClause;
    
    private String upperBoundClause;

    public InputSplit() {
    }

    public InputSplit(String lowerBoundClause, String upperBoundClause) {
        this.lowerBoundClause = lowerBoundClause;
        this.upperBoundClause = upperBoundClause;
    }

    public String getLowerBoundClause() {
        return lowerBoundClause;
    }

    public String getUpperBoundClause() {
        return upperBoundClause;
    }

    @Override
    public String toString() {
        return this.lowerBoundClause + " AND " + this.upperBoundClause;
    }
}
