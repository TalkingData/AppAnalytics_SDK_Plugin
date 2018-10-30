//
//  CustomEventGlobalKVCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "CustomEventGlobalKVCommand.h"

@implementation CustomEventGlobalKVCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *custom_event_global_str = @"\t[TalkingData setGlobalKV:<#key#> value:<#value#>];";
    
    [self insertEditableWithInvocation:invocation contents:custom_event_global_str editPosition:custom_event_global_str.length + 1];
    
    completionHandler(nil);
}


@end
