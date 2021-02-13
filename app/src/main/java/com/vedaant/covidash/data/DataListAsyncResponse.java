package com.vedaant.covidash.data;

import com.vedaant.covidash.model.actualdata;

import java.util.ArrayList;

public interface DataListAsyncResponse {
    void processFinished(ArrayList<actualdata> actualdataArrayList);
}
