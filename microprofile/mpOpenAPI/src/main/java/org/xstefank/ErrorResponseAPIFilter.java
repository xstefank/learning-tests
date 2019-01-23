package org.xstefank;

import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;

public class ErrorResponseAPIFilter implements OASFilter {

    @Override
    public APIResponse filterAPIResponse(APIResponse apiResponse) {
        apiResponse.setDescription("This is not the response you are looking for");
        
        return apiResponse;
    }
}
