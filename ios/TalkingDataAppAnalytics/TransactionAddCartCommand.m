//
//  TransactionAddCartCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "TransactionAddCartCommand.h"

@implementation TransactionAddCartCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *add_item_cart_str = @"\t[TalkingData onAddItemToShoppingCart:<#商品ID#> category:<#商品类别#> name:<#商品名称#> unitPrice:<#商品价格#> amount: <#商品数量#>];";
    
    [self insertEditableWithInvocation:invocation contents:add_item_cart_str editPosition:add_item_cart_str.length + 1];
    
    completionHandler(nil);
}

@end
