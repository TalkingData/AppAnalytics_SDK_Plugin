//
//  TransactionCheckCartCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "TransactionCheckCartCommand.h"

@implementation TransactionCheckCartCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *check_item_cart_str = @"\tTalkingDataShoppingCart *shoppingCart = [TalkingDataShoppingCart createShoppingCart];\n\
    [shoppingCart addItem:<#商品ID#> category:<#商品类别#> name:<#商品名称#> unitPrice:<#商品价格#> amount:<#商品数量#>];\n\
    [TalkingData onViewShoppingCart:shoppingCart];";
    
    [self insertEditableWithInvocation:invocation contents:check_item_cart_str editPosition:check_item_cart_str.length + 1];
    
    completionHandler(nil);
}


@end
