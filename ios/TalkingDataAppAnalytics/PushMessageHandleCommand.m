//
//  PushMessageHandleCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "PushMessageHandleCommand.h"

@implementation PushMessageHandleCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *handle_message_str = @"\tif (![TalkingData handlePushMessage:launchOptions]) {\n\
    // 非来自TalkingData的消息，可以在此处处理该消息。\n\
    \n\
    }";
    
    [self insertEditableWithInvocation:invocation contents:handle_message_str editPosition:handle_message_str.length + 1];
    
    completionHandler(nil);
}

@end
