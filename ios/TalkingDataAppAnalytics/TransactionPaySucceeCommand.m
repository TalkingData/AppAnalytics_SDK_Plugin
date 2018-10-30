//
//  TransactionPaySucceeCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "TransactionPaySucceeCommand.h"

@implementation TransactionPaySucceeCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *pay_succeed_str = @"\tTalkingDataOrder *order = [TalkingDataOrder createOrder:<#订单ID#> total:<#订单j总金额#> currencyType:<#金额单位#>];\n\
    [order addItem:<#商品ID#> category:<#商品类别#> name:<#商品名称#> unitPrice:<#商品单价#> amount:<#商品数量#>];\n\
    [TalkingData onOrderPaySucc:<#支付用户ID#> payType:<#支付方式#> order:order];";
    
    [self insertEditableWithInvocation:invocation contents:pay_succeed_str editPosition:pay_succeed_str.length + 1];
    
    completionHandler(nil);
}

@end
