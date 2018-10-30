//
//  TransactionCreateOrderCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "TransactionCreateOrderCommand.h"

@implementation TransactionCreateOrderCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *create_order_str = @"\tTalkingDataOrder *order = [TalkingDataOrder createOrder:<#订单ID#> total:<#订单j总金额#> currencyType:<#金额单位#>];\n\
    [order addItem:<#商品ID#> category:<#商品类别#> name:<#商品名称#> unitPrice:<#商品单价#> amount:<#商品数量#>];\n\
    [TalkingData onPlaceOrder:<#下单用户ID#> order:order];";
    
    [self insertEditableWithInvocation:invocation contents:create_order_str editPosition:create_order_str.length + 1];
    
    completionHandler(nil);
}

@end
