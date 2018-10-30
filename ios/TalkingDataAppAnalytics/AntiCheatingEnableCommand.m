//
//  AntiCheatingEnableCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "AntiCheatingEnableCommand.h"

@implementation AntiCheatingEnableCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *check_item_cart_str = @"\t[TalkingData setAntiCheatingEnabled:<#YES:开启|NO:关闭#>];";
    
    [self insertEditableWithInvocation:invocation contents:check_item_cart_str editPosition:check_item_cart_str.length + 1];
    
    completionHandler(nil);
}

@end
