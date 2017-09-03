package org.learn.axonframework.axonsaga.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileOrderCommand {

    private String orderId;
    private String productName;
    private String description;

}
