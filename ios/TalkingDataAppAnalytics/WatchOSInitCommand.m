//
//  WatchOSInitCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "WatchOSInitCommand.h"

@implementation WatchOSInitCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *watchos_init_str = @"\t// Watch扩展和您的主应用使用同样的App ID \n\
    [TalkingData initWithWatch:<#您的AppID#>]";
    
    [self insertEditableWithInvocation:invocation contents:watchos_init_str editPosition:watchos_init_str.length + 1];
    
    completionHandler(nil);
}

@end
