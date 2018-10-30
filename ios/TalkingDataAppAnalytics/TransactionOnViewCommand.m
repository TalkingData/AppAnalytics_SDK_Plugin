//
//  TransactionOnViewCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "TransactionOnViewCommand.h"

@implementation TransactionOnViewCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *on_view_str = @"\t[TalkingData onViewItem:<#商品ID#> category:<#商品类别#> name:<#商品名称#> unitPrice:<#商品价格#>];";
    
    [self insertEditableWithInvocation:invocation contents:on_view_str editPosition:on_view_str.length + 1];
    
    completionHandler(nil);
}

@end
