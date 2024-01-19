package com.msb.ibs.common.utils;

public class PaginationUtil
{

    public PaginationUtil()
    {
    }

    public static int calTotalPage(int pTotalRecord, int pPageSize)
    {
        int aTotalPage = pTotalRecord / pPageSize;
        if(pTotalRecord % pPageSize != 0)
            aTotalPage++;
        return aTotalPage;
    }

    public static int calFromRecordNumber(int pCurPageNO, int pPageSize)
    {
        return pPageSize * (pCurPageNO - 1) + 1;
    }

    public static int calToRecordNumber(int pCurPageNO, int pPageSize)
    {
        return pPageSize * pCurPageNO;
    }
}