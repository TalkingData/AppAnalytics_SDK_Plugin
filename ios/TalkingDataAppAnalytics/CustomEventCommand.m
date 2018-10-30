//
//  CustomEventCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "CustomEventCommand.h"

@implementation CustomEventCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *custom_event_str = @"\t[TalkingData trackEvent:<#事件 ID#>];";
    
    [self insertEditableWithInvocation:invocation contents:custom_event_str editPosition:custom_event_str.length + 1];
    
    completionHandler(nil);
}

@end
