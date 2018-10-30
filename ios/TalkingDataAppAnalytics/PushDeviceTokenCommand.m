//
//  PushDeviceTokenCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "PushDeviceTokenCommand.h"

@implementation PushDeviceTokenCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *device_token_str = @"\t[TalkingData setDeviceToken:deviceToken];";
    
    [self insertEditableWithInvocation:invocation contents:device_token_str editPosition:device_token_str.length + 1];
    
    completionHandler(nil);
}

@end
