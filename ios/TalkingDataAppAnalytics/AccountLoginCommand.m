//
//  AccountLoginCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "AccountLoginCommand.h"

@implementation AccountLoginCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *account_login_str = @"\t[TalkingData onLogin:<#账户 ID#> type:<#账户类型#> name:<#账户昵称#>];";
    
    [self insertEditableWithInvocation:invocation contents:account_login_str editPosition:account_login_str.length + 1];
    
    completionHandler(nil);
}

@end
